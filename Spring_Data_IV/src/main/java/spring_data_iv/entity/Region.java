package spring_data_iv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "regions")
public class Region extends BaseEntity {
    private String country;
    private String region;
}
