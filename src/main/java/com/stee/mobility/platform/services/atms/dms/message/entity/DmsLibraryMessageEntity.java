/**
 * Classname :DmsLibraryMessage
 * <p>
 * Description :Entity for Dms Library Message
 * <p>
 * Author : Myo Thazin Khaing
 **/

package com.stee.mobility.platform.services.atms.dms.message.entity;

import com.stee.mobility.platform.common.entity.AbstractEntityBase;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "DMS_LIBRARY_MESSAGE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DmsLibraryMessageEntity extends AbstractEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "MSG_TYPE_ID")
    private Long msgTypeId;


    @Column(name = "ROAD_NAME")
    private String roadName;

    @NotNull
    @Column(name = "TOTAL_PAGES")
    private int totalPages;

    @NotEmpty
    @Column(name = "DISPLAY_MODE")
    private String displayMode;

    @NotEmpty
    @Column(name = "TOGGLE_MODE")
    private String toggleMode;

    @Column(name = "MSG_DESC1")
    private String msgDesc1;

    @Column(name = "MSG_DESC2")
    private String msgDesc2;

    @Column(name = "APPROVED_BY")
    private String approvedBy;

    @Column(name = "APPROVED_DATE")
    private ZonedDateTime approvedDate;

    @Column(name = "REVIEWED_BY")
    private String reviewedBy;

    @Column(name = "REVIEWED_DATE")
    private ZonedDateTime reviewedDate;

    @Column(name = "MSG_STATUS")
    private int msgStatus;

    @Column(name = "DFT_DMS_TYPE")
    private String dftDmsType;

    @Column(name = "SPT_DMS_TYPE")
    private String sptDmsType;

    @Column(name = "REMARK")
    private String remark;

//    @OneToMany(mappedBy = "libraryMessage", cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @Where(clause = "is_obsolete = 0")
//    private List<DmsLibraryMessagePageEntity> libraryMsgPages;

    @NotNull
    @Column(name = "IS_OBSOLETE")
    private Integer obsolete;

}

