package com.stee.mobility.platform.services.atms.dms.message.service;

import com.stee.mobility.platform.services.atms.dms.message.domain.ResultBean;
import com.stee.mobility.platform.services.atms.dms.message.entity.MessageLibrary;

import java.util.List;

/**
 * @author Administrator
 * @Class Name MessageLibraryService
 * @Desc
 * @create: 2021-01-19 13:20
 **/
public interface MessageLibraryService {


    /**
     * Save data to table
     *
     * @param messageLibraryList The data that need save
     * @return 200 save successfully
     */
    ResultBean saveAll(List<MessageLibrary> messageLibraryList);
}
