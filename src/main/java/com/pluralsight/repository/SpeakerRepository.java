package com.pluralsight.repository;
/* conference-service
 * @created 05/20/2022
 * @author Konstantin Staykov
 */

import com.pluralsight.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();

    Speaker findById(Long id);

    Speaker create(Speaker speaker);

    Speaker update(Speaker speaker);

    void delete(Long id);
}
