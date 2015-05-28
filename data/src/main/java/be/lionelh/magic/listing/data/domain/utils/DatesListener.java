package be.lionelh.magic.listing.data.domain.utils;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.apache.log4j.Logger;

/**
 * @author Lionel
 */
public class DatesListener {

    private static final Logger LOG = Logger.getLogger(DatesListener.class);

    @PrePersist
    public void beforePersist(Storable inStorable) {
        Date now = new Date();
        inStorable.setCreationDate(now);
        inStorable.setLastUpdateDate(now);
    }

    @PreUpdate
    public void beforeUpdate(Storable inStorable) {
        LOG.debug("In DatesListener.beforeUpdate");
        Date now = new Date();
        inStorable.setLastUpdateDate(now);
    }
}
