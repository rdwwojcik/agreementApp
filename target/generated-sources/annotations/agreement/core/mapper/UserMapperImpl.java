package agreement.core.mapper;

import agreement.core.dto.UserDTO;
import agreement.core.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-05-24T22:51:38+0200",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_60 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setLastName( userDTO.getLastName() );
        user.setLogin( userDTO.getLogin() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setLogin( user.getLogin() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public List<User> fromDTO(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>();
        for ( UserDTO userDTO : dtoList ) {
            list.add( fromDTO( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDTO(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>();
        for ( User user : users ) {
            list.add( toDTO( user ) );
        }

        return list;
    }
}
