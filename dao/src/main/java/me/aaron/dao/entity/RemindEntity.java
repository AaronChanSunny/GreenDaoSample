package me.aaron.dao.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import me.aaron.dao.greenGen.DaoSession;
import me.aaron.dao.greenGen.RemindEntityDao;
import me.aaron.dao.greenGen.TaskEntityDao;

/**
 * Created by Chenll on 2016/8/25 0025.
 */
@Entity
public class RemindEntity {

    @Id
    private Long id;

    private int remindTime;
    private long taskId;
    @ToOne(joinProperty = "taskId")
    private TaskEntity task;
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
    @Generated(hash = 865111949)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRemindEntityDao() : null;
    }
    /** Used for active entity operations. */
    @Generated(hash = 1790938498)
    private transient RemindEntityDao myDao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    public long getTaskId() {
        return this.taskId;
    }
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    public int getRemindTime() {
        return this.remindTime;
    }
    public void setRemindTime(int remindTime) {
        this.remindTime = remindTime;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 56916000)
    public RemindEntity(Long id, int remindTime, long taskId) {
        this.id = id;
        this.remindTime = remindTime;
        this.taskId = taskId;
    }
    @Generated(hash = 483196385)
    public RemindEntity() {
    }

}
