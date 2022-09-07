package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.ClassRoom;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

	
}
