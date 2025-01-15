import services.*;
import repository.*;
import models.*;
import exceptions.*;


import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import javax.persistence.EntityNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    
    @Mock
    UsersRepository usersRepository;

    @Test
    public void testAutherication() {
        User user = new User(1,"hamza", "123456789", false);
        when(usersRepository.findByLogin("hamza")).thenReturn(user)
                                                        .thenThrow(new EntityNotFoundException())
                                                        .thenReturn(user);
        doNothing().when(usersRepository).update(user);
        UserServiceImpl userServiceImpl = new UserServiceImpl(this.usersRepository);

        assertTrue( userServiceImpl.authenticate("hamza", "123456789"));
        verify(usersRepository).update(user);

        assertThrows(EntityNotFoundException.class ,()->{
            userServiceImpl.authenticate("hamza", "123456789");
        });

        assertThrows(AlreadyAuthenticatedException.class ,()->{
            userServiceImpl.authenticate("hamza", "dkashbdahksdhk");
        });

    }
}
