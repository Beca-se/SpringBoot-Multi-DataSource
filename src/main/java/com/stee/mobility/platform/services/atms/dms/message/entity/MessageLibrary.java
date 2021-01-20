package com.stee.mobility.platform.services.atms.dms.message.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @author Administrator
 * @Class Name MessageLibrary
 * @Desc
 * @create: 2021-01-19 11:54
 **/
@Entity
@Table(name = "messagelibrary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MessageLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @NotNull
    @Length(min = 0, max = 50, message = "The message name max length is 50.")
    private String name;

    @Column(name = "page1MultiStr")
    @NotNull
    private byte[] page1MultiStr;

    @Column(name = "page2MultiStr")
    private byte[] page2MultiStr;

    @Column(name = "adddate")
    private ZonedDateTime addDate;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPage1MultiStr() {
        return page1MultiStr;
    }

    public void setPage1MultiStr(byte[] page1MultiStr) {
        this.page1MultiStr = page1MultiStr;
    }

    public byte[] getPage2MultiStr() {
        return page2MultiStr;
    }

    public void setPage2MultiStr(byte[] page2MultiStr) {
        this.page2MultiStr = page2MultiStr;
    }

    public ZonedDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(ZonedDateTime addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageLibrary{");
        sb.append("messageId=").append(messageId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", page1MultiStr=").append(Arrays.toString(page1MultiStr));
        sb.append(", page2MultiStr=").append(Arrays.toString(page2MultiStr));
        sb.append(", addDate=").append(addDate);
        sb.append('}');
        return sb.toString();
    }
}
