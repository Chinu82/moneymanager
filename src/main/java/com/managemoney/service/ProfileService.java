package com.managemoney.service;

import com.managemoney.dto.ProfileDTO;
import com.managemoney.entity.ProfileEntity;
import com.managemoney.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final EmailService emailService;

    public ProfileDTO registerProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileEntity newProfile = toEntity(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        newProfile = profileRepository.save(newProfile);
        String activationLink ="http://localhost:9090/api/v1.0/activate?token="+newProfile.getActivationToken();
        String subject = "Activate your Money Manager Account";
        String emailBody = "Click on the following link to activate your Account : "+activationLink;

        emailService.sendEmail(newProfile.getEmail(), subject,emailBody);
        return  toDto(newProfile);
    }

    public ProfileEntity toEntity(ProfileDTO profileDTO){
        return ProfileEntity.builder()
                .id(profileDTO.getId())
                .fullName(profileDTO.getFullName())
                .email(profileDTO.getEmail())
                .createdAt(profileDTO.getCreatedAt())
                .updatedAt(profileDTO.getUpdatedAt())
                .profileImgUrl(profileDTO.getProfileImgUrl())
                .password(profileDTO.getPassword())
                .build();
    }

    public ProfileDTO toDto(ProfileEntity profileEntity){
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .profileImgUrl(profileEntity.getProfileImgUrl())
                .password(profileEntity.getPassword())
                .build();
    }
}


//config with mail message : 1:11:42