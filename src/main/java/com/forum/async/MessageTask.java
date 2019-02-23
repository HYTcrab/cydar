package com.forum.async;

import com.forum.mapper.MessageMapper;
import com.forum.mapper.PostMapper;
import com.forum.mapper.ReplyMapper;
import com.forum.mapper.UserMapper;
import com.forum.model.Message;
import com.forum.model.User;
import com.forum.util.MyConstant;
import jdk.internal.org.objectweb.asm.commons.Remapper;

public class MessageTask implements Runnable{
    private MessageMapper messageMapper;
    private UserMapper userMapper;
    private PostMapper postMapper;
    private ReplyMapper replyMapper;
    private int pid;
    private int rid;
    private int sessionUid;
    private int operation;

    public MessageTask(MessageMapper messageMapper, UserMapper userMapper, PostMapper postMapper, ReplyMapper replyMapper, int pid, int rid, int sessionUid, int operation) {
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
        this.postMapper = postMapper;
        this.replyMapper = replyMapper;
        this.pid = pid;
        this.rid = rid;
        this.sessionUid = sessionUid;
        this.operation = operation;
    }

    @Override
    public void run() {
        //创建新消息对象
        Message message = new Message();
        //设置是谁的消息
        int uid = postMapper.getUidByPid(pid);
        message.setUid(uid);

        //设置点赞人id和用户名
        User user = userMapper.selectUsernameByUid(sessionUid);
        message.setOtherId(user.getUid());
        message.setOtherUsername(user.getUsername());
        message.setPostId(pid);

        if(operation== MyConstant.OPERATION_CLICK_LIKE){
            message.setOperation("赞了您的贴子");
            message.setDisplayedContent(postMapper.getTitleByPid(pid));
        }else if (operation==MyConstant.OPERATION_COMMENT){
            message.setOperation("回复了您的帖子");
            message.setDisplayedContent(postMapper.getTitleByPid(pid));
        }else if(operation==MyConstant.OPERATION_COMMENT){
            message.setOperation("评论了你帖子的回复");
            String content = replyMapper.getContentByRid(rid);
            message.setDisplayedContent(content.substring(content.indexOf("<p>")+3,content.indexOf("</p>")));
        }

        //向数据库插入一条消息
        messageMapper.insertMessage(message);
    }
}
