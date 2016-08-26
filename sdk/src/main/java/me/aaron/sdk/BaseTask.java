package me.aaron.sdk;

import java.util.ArrayList;
import java.util.List;

import me.aaron.dao.IDbOperator;
import me.aaron.dao.entity.FileEntity;
import me.aaron.dao.entity.TaskEntity;

/**
 * Created by Chenll on 2016/8/25 0025.
 */
public class BaseTask implements ITask {

    private IDbOperator mDbOperator;
    private TaskEntity mTaskEntity;

    public BaseTask() {
        mTaskEntity = mDbOperator.getTaskBySeqId(0);
    }

    @Override
    public String getSeqId() {
        return null;
    }

    @Override
    public void uploadFile() {

    }

    @Override
    public List<IFile> getFiles() {
        List<IFile> results = new ArrayList<>();
        List<FileEntity> fileEntities = mTaskEntity.getAttachFiles();
        for (FileEntity fileEntity : fileEntities) {
            results.add(new BaseFile(fileEntity));
        }
        return results;
    }

    @Override
    public int getIsStart() {
        return mTaskEntity.getIsStar();
    }

    @Override
    public void setIsStart(int isStart) {
        mTaskEntity.setIsStar(isStart);
    }

}
