package com.stee.mobility.platform.services.atms.dms.message.service.impl;


import com.google.gson.Gson;
import com.stee.mobility.platform.services.atms.dms.message.domain.ResultBean;
import com.stee.mobility.platform.services.atms.dms.message.entity.MessageLibrary;
import com.stee.mobility.platform.services.atms.dms.message.intf.DataSourceChoose;
import com.stee.mobility.platform.services.atms.dms.message.repository.MessageLibraryRepository;
import com.stee.mobility.platform.services.atms.dms.message.service.MessageLibraryService;
import com.stee.mobility.platform.services.atms.dms.message.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author Administrator
 * @Class Name MessageLibraryServiceImpl
 * @Desc
 * @create: 2021-01-19 13:22
 **/

@Service
public class MessageLibraryServiceImpl implements MessageLibraryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageLibraryServiceImpl.class);

    private static final Gson GSON = GsonUtils.getPtzGson();
    @Autowired
    private MessageLibraryRepository messageLibraryRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSourceChoose
    public ResultBean saveAll(List<MessageLibrary> messageLibraryList) {
        try {
            if (messageLibraryList == null) {
                return ResultBean.isBad("The input data can't be null.");
            }
            LOGGER.info("Start save message library. The data size is {}.", messageLibraryList.size());
            LOGGER.debug("The data is {}.", GSON.toJson(messageLibraryList));
            List<MessageLibrary> messageLibraries = messageLibraryRepository.saveAll(messageLibraryList);
            return ResultBean.isOK("Save message library data successfully.", messageLibraries);
        } catch (Exception ex) {
            LOGGER.error("Save message library error. Cause by {}.", ex);
            LOGGER.error("The error data is {}.", GSON.toJson(messageLibraryList));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultBean.isError("SYSTEM ERROR.");
    }
}
