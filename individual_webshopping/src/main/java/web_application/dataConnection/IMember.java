package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Member;

public interface IMember extends JpaRepository<Member,Long> {

}
