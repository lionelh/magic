package be.lionelh.magic.listing.data.domain.utils;

import java.util.Date;

/**
 * @author Lionel
 */
public interface Storable {

    void setCreationDate(Date inDate);

    void setLastUpdateDate(Date inDate);
}
