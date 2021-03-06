package org.dcsc.core.activity;

import org.dcsc.core.user.DcscUser;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by tktong on 7/19/15.
 */
@Entity
@Table(name = "activity_log", schema = "administration")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private DcscUser user;

    @Column(name = "action", nullable = false)
    @Enumerated(EnumType.STRING)
    private Action action;

    @Column(name = "target", nullable = false)
    private String target;

    @Column(name = "description")
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time", nullable = false)
    private Time time;

    public Activity() {

    }

    public Activity(DcscUser user, Action action, String target, String description, Date date, Time time) {
        this.user = user;
        this.action = action;
        this.target = target;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DcscUser getUser() {
        return user;
    }

    public void setUser(DcscUser user) {
        this.user = user;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
