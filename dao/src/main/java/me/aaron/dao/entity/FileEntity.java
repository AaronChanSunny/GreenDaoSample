package me.aaron.dao.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import me.aaron.dao.greenGen.DaoSession;
import me.aaron.dao.greenGen.FileEntityDao;
import me.aaron.dao.greenGen.TaskEntityDao;

/**
 * Created by Chenll on 2016/8/25 0025.
 */
@Entity
public class FileEntity {

    @Id
    private Long id;

    private long taskId;
    @ToOne(joinProperty = "taskId")
    private TaskEntity task;
    private int fileType;
    private String fileName;
    private long fileSize;
    private String dentryID;
    private String md5;
    private long uploadTime;
    private String localFilePath;
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
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 707094297)
    public void setTask(@NotNull TaskEntity task) {
        if (task == null) {
            throw new DaoException(
                    "To-one property 'taskId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.task = task;
            taskId = task.getSeqID();
            task__resolvedKey = taskId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 797406797)
    public TaskEntity getTask() {
        long __key = this.taskId;
        if (task__resolvedKey == null || !task__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskEntityDao targetDao = daoSession.getTaskEntityDao();
            TaskEntity taskNew = targetDao.load(__key);
            synchronized (this) {
                task = taskNew;
                task__resolvedKey = __key;
            }
        }
        return task;
    }
    @Generated(hash = 100676365)
    private transient Long task__resolvedKey;
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1431751175)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFileEntityDao() : null;
    }
    /** Used for active entity operations. */
    @Generated(hash = 1194307080)
    private transient FileEntityDao myDao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    public String getLocalFilePath() {
        return this.localFilePath;
    }
    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath;
    }
    public long getUploadTime() {
        return this.uploadTime;
    }
    public void setUploadTime(long uploadTime) {
        this.uploadTime = uploadTime;
    }
    public String getMd5() {
        return this.md5;
    }
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    public String getDentryID() {
        return this.dentryID;
    }
    public void setDentryID(String dentryID) {
        this.dentryID = dentryID;
    }
    public long getFileSize() {
        return this.fileSize;
    }
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public int getFileType() {
        return this.fileType;
    }
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
    public long getTaskId() {
        return this.taskId;
    }
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1279942808)
    public FileEntity(Long id, long taskId, int fileType, String fileName,
            long fileSize, String dentryID, String md5, long uploadTime,
            String localFilePath) {
        this.id = id;
        this.taskId = taskId;
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.dentryID = dentryID;
        this.md5 = md5;
        this.uploadTime = uploadTime;
        this.localFilePath = localFilePath;
    }
    @Generated(hash = 1879603201)
    public FileEntity() {
    }

}
