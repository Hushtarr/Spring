package spring_data_iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_data_iv.entity.Region;

import java.util.List;
// drive query


public interface RegionRepository extends JpaRepository<Region, Integer>
    {
    List<Region> findByCountry(String country);
    List<Region> findByCountryContaining(String country);
    List<Region> findByCountryContainsOrderByRegion(String country);
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByRegionOrderByCountryAsc(String country);
    /*Find                  by
    * select     from       where
    * */
    }
