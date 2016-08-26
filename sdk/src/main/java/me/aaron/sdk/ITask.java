package me.aaron.sdk;

import java.util.List;

/**
 * Created by Chenll on 2016/8/26.
 */
public interface ITask {

    String getSeqId();

    void uploadFile();

    List<IFile> getFiles();

    int getIsStart();

    void setIsStart(int isStart);

}
