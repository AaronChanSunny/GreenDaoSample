package me.aaron.dao.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import me.aaron.dao.greenGen.DaoSession;
import me.aaron.dao.greenGen.FileEntityDao;
import me.aaron.dao.greenGen.ReceiverEntityDao;
import me.aaron.dao.greenGen.RemindEntityDao;
import me.aaron.dao.greenGen.TaskEntityDao;

/**
 * Created by Chenll on 2016/8/25 0025.
 */
@Entity
public class TaskEntity {

    /**
     * 用户任务记录号，同时作为任务表的主键。
     * 外部可能会在入库前就获取seqID，所以这里需要先做初始化。
     */
    @Id
    private Long seqID = 0L;
    private long ownerUID;
    private long senderUID;
    private String sendName;
    private long orgID;
    private String clientTaskID;
    private long taskID;
    private int selfTask;
    /**
     * 我的进度。
     * 0到1，两位小数
     */
    private double myProgress;
    /**
     * 任务星标。
     * 1 是
     * 0 否
     */
    private int isStar;
    /**
     * 任务描述。
     */
    private String descript;
    private String title;
    /**
     * 我的任务状态。
     */
    private int myStatus;
    /**
     * 发送者看到的任务状态。
     */
    private int status;
    /**
     * 任务优先级。
     */
    private int priority;
    private int commentNum;
    private int attachmentNum;
    private long startTime;
    private long endTime;
    private long createTime;
    private long finishTime;
    private long updateTime;
    /**
     * 服务端提醒。
     * 例如1440,60，单位分钟，数组长度不能大于2，无提醒传空数组
     */
    @ToMany(joinProperties = {
            @JoinProperty(name = "seqID", referencedName = "taskId")
    })
    private List<RemindEntity> reminds;
    @ToMany(joinProperties = {
            @JoinProperty(name = "seqID", referencedName = "taskId")
    })
    private List<ReceiverEntity> receivers;
    @ToMany(joinProperties = {
            @JoinProperty(name = "seqID", referencedName = "taskId")
    })
    private List<FileEntity> attachFiles;

    private String path;
    private String session;
    private int expires;
    private long serverTime;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 263689402)
    private transient TaskEntityDao myDao;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    @Generated(hash = 370096422)
    public TaskEntity(Long seqID, long ownerUID, long senderUID, String sendName,
                      long orgID, String clientTaskID, long taskID, int selfTask,
                      double myProgress, int isStar, String descript, String title,
                      int myStatus, int status, int priority, int commentNum,
                      int attachmentNum, long startTime, long endTime,
                      long createTime, long finishTime, long updateTime, String path,
                      String session, int expires, long serverTime) {
        this.seqID = seqID;
        this.ownerUID = ownerUID;
        this.senderUID = senderUID;
        this.sendName = sendName;
        this.orgID = orgID;
        this.clientTaskID = clientTaskID;
        this.taskID = taskID;
        this.selfTask = selfTask;
        this.myProgress = myProgress;
        this.isStar = isStar;
        this.descript = descript;
        this.title = title;
        this.myStatus = myStatus;
        this.status = status;
        this.priority = priority;
        this.commentNum = commentNum;
        this.attachmentNum = attachmentNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.finishTime = finishTime;
        this.updateTime = updateTime;
        this.path = path;
        this.session = session;
        this.expires = expires;
        this.serverTime = serverTime;
    }

    @Generated(hash = 397975341)
    public TaskEntity() {
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1460259300)
    public synchronized void resetAttachFiles() {
        attachFiles = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1201496646)
    public List<FileEntity> getAttachFiles() {
        if (attachFiles == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FileEntityDao targetDao = daoSession.getFileEntityDao();
            List<FileEntity> attachFilesNew = targetDao._queryTaskEntity_AttachFiles(seqID);
            synchronized (this) {
                if (attachFiles == null) {
                    attachFiles = attachFilesNew;
                }
            }
        }
        return attachFiles;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 2097591286)
    public synchronized void resetReceivers() {
        receivers = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1326826395)
    public List<ReceiverEntity> getReceivers() {
        if (receivers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ReceiverEntityDao targetDao = daoSession.getReceiverEntityDao();
            List<ReceiverEntity> receiversNew = targetDao._queryTaskEntity_Receivers(seqID);
            synchronized (this) {
                if (receivers == null) {
                    receivers = receiversNew;
                }
            }
        }
        return receivers;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1469250469)
    public synchronized void resetReminds() {
        reminds = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1041765136)
    public List<RemindEntity> getReminds() {
        if (reminds == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RemindEntityDao targetDao = daoSession.getRemindEntityDao();
            List<RemindEntity> remindsNew = targetDao._queryTaskEntity_Reminds(seqID);
            synchronized (this) {
                if (reminds == null) {
                    reminds = remindsNew;
                }
            }
        }
        return reminds;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 424431507)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskEntityDao() : null;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public int getExpires() {
        return this.expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getAttachmentNum() {
        return this.attachmentNum;
    }

    public void setAttachmentNum(int attachmentNum) {
        this.attachmentNum = attachmentNum;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMyStatus() {
        return this.myStatus;
    }

    public void setMyStatus(int myStatus) {
        this.myStatus = myStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getIsStar() {
        return this.isStar;
    }

    public void setIsStar(int isStar) {
        this.isStar = isStar;
    }

    public double getMyProgress() {
        return this.myProgress;
    }

    public void setMyProgress(double myProgress) {
        this.myProgress = myProgress;
    }

    public int getSelfTask() {
        return this.selfTask;
    }

    public void setSelfTask(int selfTask) {
        this.selfTask = selfTask;
    }

    public long getTaskID() {
        return this.taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getClientTaskID() {
        return this.clientTaskID;
    }

    public void setClientTaskID(String clientTaskID) {
        this.clientTaskID = clientTaskID;
    }

    public long getOrgID() {
        return this.orgID;
    }

    public void setOrgID(long orgID) {
        this.orgID = orgID;
    }

    public String getSendName() {
        return this.sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public long getSenderUID() {
        return this.senderUID;
    }

    public void setSenderUID(long senderUID) {
        this.senderUID = senderUID;
    }

    public long getOwnerUID() {
        return this.ownerUID;
    }

    public void setOwnerUID(long ownerUID) {
        this.ownerUID = ownerUID;
    }

    public Long getSeqID() {
        return this.seqID;
    }

    public void setSeqID(Long seqID) {
        this.seqID = seqID;
    }

}
