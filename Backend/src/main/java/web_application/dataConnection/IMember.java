package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Member;

import java.util.Optional;

public interface IMember extends JpaRepository<Member,Long> {
    Optional<Member> getMemberByUsername(String username);
}
