package be.lionelh.magic.listing.data.domain.dao;

import java.util.List;

import be.lionelh.magic.listing.data.domain.entities.Capacity;

public interface CapacityDao {

	Capacity create(Capacity inCapacity);
    List<Capacity> findAll();
    Capacity findById(Long inId);
    Capacity findByName(String inName);
    Capacity findByNom(String inNom);
    Capacity update(Capacity inCapacity);
    void delete(Capacity inCapacity);
}
