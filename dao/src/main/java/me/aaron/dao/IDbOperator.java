package me.aaron.dao;

import me.aaron.dao.entity.TaskEntity;

/**
 * Created by Chenll on 2016/8/26.
 */
public interface IDbOperator {

    TaskEntity getTaskBySeqId(long seqId);

    void saveOrUpdate(TaskEntity taskEntity);

}
