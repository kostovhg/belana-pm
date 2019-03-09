package com.belana.production.domain.entities.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MapKeyTemporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 * Custom id class that combines date and time as composite key for id
 */
@Embeddable
class TemporalKey implements Serializable {

    @MapKeyTemporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @MapKeyTemporal(TemporalType.TIME)
    @Column(name = "time", nullable = false)
    private Time time;

    public TemporalKey() {
    }

    public TemporalKey(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemporalEntity)) return false;
        TemporalKey that = (TemporalKey) o;
        return Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTime());
    }


}
