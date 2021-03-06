package cm.ubuea.covider.registration.service.serviceImpl;

import cm.ubuea.covider.registration.domain.UserLocation;
import cm.ubuea.covider.registration.repository.UserLocationRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.UserLocationService;
import cm.ubuea.covider.registration.service.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserLocationServiceImpl implements UserLocationService {
@Autowired
UserLocationRepository userLocationRepository;
@Autowired
UserRepository userRepository;

    @Override
    public void addUserLocation(LocationDTO locationDTO) {
        UserLocation userLocation = new UserLocation();
        userLocation.setCurrentLoctaion(locationDTO.getCurrent_loctaion());
        userLocation.setPreviousLocation(locationDTO.getPrevious_location());
        userLocation.setUser(userRepository.findOneByIdNumber(locationDTO.getUserIdNumber()).orElse(null));
        userLocationRepository.save(userLocation);
    }
    }
