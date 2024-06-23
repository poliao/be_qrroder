package com.example.newweb.service;

import com.example.newweb.entityinnewuppop.Activity;
import com.example.newweb.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity activityDetails) {
        return activityRepository.findById(id).map(activity -> {
            activity.setDate_Start(activityDetails.getDate_Start());
            activity.setTime_Start(activityDetails.getTime_Start());
            activity.setDate_end(activityDetails.getDate_end());
            activity.setTime_end(activityDetails.getTime_end());
            activity.setLocation(activityDetails.getLocation());
            activity.setNameActivity(activityDetails.getNameActivity());
            activity.setCategory(activityDetails.getCategory());
            activity.setUrlimg(activityDetails.getUrlimg());
            activity.setDetail(activityDetails.getDetail());
            return activityRepository.save(activity);
        }).orElseGet(() -> {
            activityDetails.setIdActivity(id);
            return activityRepository.save(activityDetails);
        });
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}