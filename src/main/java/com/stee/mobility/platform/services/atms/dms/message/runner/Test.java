package com.stee.mobility.platform.services.atms.dms.message.runner;

import com.stee.mobility.platform.services.atms.dms.message.domain.ResultBean;
import com.stee.mobility.platform.services.atms.dms.message.entity.MessageLibrary;
import com.stee.mobility.platform.services.atms.dms.message.service.MessageLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Class Name Test
 * @Desc TODO
 * @create: 2021-01-18 11:31
 **/
@Configuration
public class Test implements ApplicationRunner {


    @Autowired
    MessageLibraryService messageLibraryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        MessageLibrary messageLibrary = new MessageLibrary();
        messageLibrary.setName("TEST_OONE");
        messageLibrary.setPage1MultiStr(new byte[10]);
        List<MessageLibrary> libraryList = new ArrayList<>();
        libraryList.add(messageLibrary);
        ResultBean resultBean = messageLibraryService.saveAll(libraryList);
        System.out.println("ONE" + resultBean);
        messageLibrary.setAddDate(ZonedDateTime.now());


        resultBean = messageLibraryService.saveAll(libraryList);
        System.out.println("Two" + resultBean);

    }
}
