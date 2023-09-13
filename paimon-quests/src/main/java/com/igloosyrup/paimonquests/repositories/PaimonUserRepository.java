package com.igloosyrup.paimonquests.repositories;

import com.igloosyrup.paimonquests.models.PaimonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaimonUserRepository extends JpaRepository<PaimonUser, Integer> {

    PaimonUser findPaimonUserByUserName(String userName);

}
