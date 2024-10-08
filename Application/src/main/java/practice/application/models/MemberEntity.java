package practice.application.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.application.models.enumType.UserType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email; //로그인은 이메일로

    private String name;

    private String password;

    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Embedded
    private Address address;

    public MemberEntity(String email, String name, String password, String phoneNumber, UserType userType, Address address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.address = address;
    }

    public void encodePassword(String password){
        this.password = password;
    }
}
