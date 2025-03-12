package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.model.Post;
import com.example.backend.repository.PostRepository;
import java.util.List;
import java.sql.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getClosedPosts(Date currentDate) {
        return postRepository.findByClosingDateLessThan(currentDate);
    }

    public int calculateCandidateScore(Post post, com.example.backend.model.Candidate candidate) {
        int score = 0;

        if (post.getDriversLicenseRequired().equalsIgnoreCase(candidate.getDriversLicense())) {
            score += 2;
        }

        if (isQualificationMet(post.getQualificationRequirements(), candidate.getQualification())) {
            score += 2;
        }

        if (isExperienceMet(post.getExperienceYears(), candidate.getExperienceYears())) {
            score += 2;
        }

        return score;
    }

    private boolean isQualificationMet(String required, String candidate) {
        //I need to  Implement qualification comparison logic here
        
        return candidate.equalsIgnoreCase(required);
    }

    private boolean isExperienceMet(String required, int candidate) {
        //I need  to  Implement experience comparison logic here
     
        try{
            int requiredYears = Integer.parseInt(required.replaceAll("[^0-9]",""));
            return candidate >= requiredYears;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
