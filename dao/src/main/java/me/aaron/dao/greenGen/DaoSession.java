package me.aaron.dao.greenGen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import me.aaron.dao.entity.FileEntity;
import me.aaron.dao.entity.ReceiverEntity;
import me.aaron.dao.entity.RemindEntity;
import me.aaron.dao.entity.TaskEntity;

import me.aaron.dao.greenGen.FileEntityDao;
import me.aaron.dao.greenGen.ReceiverEntityDao;
import me.aaron.dao.greenGen.RemindEntityDao;
import me.aaron.dao.greenGen.TaskEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig fileEntityDaoConfig;
    private final DaoConfig receiverEntityDaoConfig;
    private final DaoConfig remindEntityDaoConfig;
    private final DaoConfig taskEntityDaoConfig;

    private final FileEntityDao fileEntityDao;
    private final ReceiverEntityDao receiverEntityDao;
    private final RemindEntityDao remindEntityDao;
    private final TaskEntityDao taskEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        fileEntityDaoConfig = daoConfigMap.get(FileEntityDao.class).clone();
        fileEntityDaoConfig.initIdentityScope(type);

        receiverEntityDaoConfig = daoConfigMap.get(ReceiverEntityDao.class).clone();
        receiverEntityDaoConfig.initIdentityScope(type);

        remindEntityDaoConfig = daoConfigMap.get(RemindEntityDao.class).clone();
        remindEntityDaoConfig.initIdentityScope(type);

        taskEntityDaoConfig = daoConfigMap.get(TaskEntityDao.class).clone();
        taskEntityDaoConfig.initIdentityScope(type);

        fileEntityDao = new FileEntityDao(fileEntityDaoConfig, this);
        receiverEntityDao = new ReceiverEntityDao(receiverEntityDaoConfig, this);
        remindEntityDao = new RemindEntityDao(remindEntityDaoConfig, this);
        taskEntityDao = new TaskEntityDao(taskEntityDaoConfig, this);

        registerDao(FileEntity.class, fileEntityDao);
        registerDao(ReceiverEntity.class, receiverEntityDao);
        registerDao(RemindEntity.class, remindEntityDao);
        registerDao(TaskEntity.class, taskEntityDao);
    }
    
    public void clear() {
        fileEntityDaoConfig.getIdentityScope().clear();
        receiverEntityDaoConfig.getIdentityScope().clear();
        remindEntityDaoConfig.getIdentityScope().clear();
        taskEntityDaoConfig.getIdentityScope().clear();
    }

    public FileEntityDao getFileEntityDao() {
        return fileEntityDao;
    }

    public ReceiverEntityDao getReceiverEntityDao() {
        return receiverEntityDao;
    }

    public RemindEntityDao getRemindEntityDao() {
        return remindEntityDao;
    }

    public TaskEntityDao getTaskEntityDao() {
        return taskEntityDao;
    }

}
