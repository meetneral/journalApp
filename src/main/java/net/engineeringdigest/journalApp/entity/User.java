package net.engineeringdigest.journalApp.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;


@Document(collection="users")

@Data
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)// even though we add this annotation it will not start indexing unless you add auto-index-creation=true in application properties
    private String username;
    @NonNull
    private String password;

    private List<String> roles;
    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();






}
