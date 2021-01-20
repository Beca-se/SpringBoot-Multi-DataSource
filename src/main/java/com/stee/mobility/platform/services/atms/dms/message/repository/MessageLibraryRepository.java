package com.stee.mobility.platform.services.atms.dms.message.repository;

import com.stee.mobility.platform.services.atms.dms.message.entity.MessageLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Class Name MessageLibraryRepository
 * @Desc
 * @create: 2021-01-19 13:19
 **/
@Repository
public interface MessageLibraryRepository extends JpaRepository<MessageLibrary, Long> {
}
