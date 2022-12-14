package com.mysport.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SportBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private Integer user_id;
	
	@Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "end")
    private Date end;

//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
////    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    @Column(name = "canceled_at")
//    private Date canceledAt;

//    @ManyToOne
//    @JoinColumn(name = "id_canceler")
//    private User canceler;

    @Column(name = "status")
    private Integer status;
    
//    @ManyToOne
//    @JoinColumn(name = "id_sport")
    private String sportName;


    public SportBooking() {
    	
    }

    public SportBooking(Date start, Date end, Integer user_id) {
        this.start = start;
        this.end = end;
        this.user_id = user_id;
    }

}
