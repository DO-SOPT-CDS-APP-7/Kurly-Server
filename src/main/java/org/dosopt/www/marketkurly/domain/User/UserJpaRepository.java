package org.dosopt.www.marketkurly.domain.User;

import org.dosopt.www.marketkurly.domain.User.entity.User;
import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.domain.UserException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new UserException(CustomErrorCode.USER_NOT_FOUND));
    }
}
