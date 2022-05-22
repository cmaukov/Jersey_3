package com.pluralsight.repository;
/* conference-service
 * @created 05/20/2022
 * @author Konstantin Staykov
 */

import com.pluralsight.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerRepositoryStub implements SpeakerRepository {
    private static List<Speaker> speakers = new ArrayList<>();

    public SpeakerRepositoryStub() {

        speakers.add(new Speaker(1L, "bob", "jimmyBobs"));
        speakers.add(new Speaker(2L, "ivan", "chukanite"));
    }

    @Override
    public List<Speaker> findAll() {

        return speakers;
    }

    @Override
    public Speaker findById(Long id) {
        return speakers.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Speaker create(Speaker speaker) {
        speaker.setId(speakers.size()+1L);
        speakers.add(speaker);
        return speaker;
    }
}
