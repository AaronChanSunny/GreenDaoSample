package me.aaron.sdk;

import me.aaron.dao.entity.FileEntity;

/**
 * Created by Chenll on 2016/8/26.
 */
public class BaseFile implements IFile {

    private FileEntity mFileEntity;

    public BaseFile(FileEntity fileEntity) {
        mFileEntity = fileEntity;
    }
}
