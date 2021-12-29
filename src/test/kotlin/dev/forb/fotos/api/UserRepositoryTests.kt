package dev.forb.fotos.api

import dev.forb.fotos.api.entities.User
import dev.forb.fotos.api.repositories.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.Rollback

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTests {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var repository: UserRepository

    @Test
    fun `Create new user`() {
        val user = User(email = "veryRealEmail@example.dev", username = "veryRealUser", password = "veryRealPassword")
        val savedUser = repository.save(user)
        val existUser = entityManager.find<User>(User::class.java, savedUser.id)
        assertThat(user.email).isEqualTo(existUser.email);
    }

    @Test
    fun `Find user by login`() {
        val user = User(email = "veryRealEmail@example.dev", username = "veryRealUser", password = "veryRealPassword")
        repository.save(user)
        assertThat(repository.findForLogin("veryRealUser")?.username).isEqualTo(repository.findForLogin("veryRealEmail@example.dev")?.username)
    }

}
