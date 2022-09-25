package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.easyfinapi.domains.CourseStage;

@NoRepositoryBean
public interface CourseStageRepository extends JpaRepository<CourseStage, Integer> {
}
