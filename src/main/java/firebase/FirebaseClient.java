package firebase;
import dto.NotificationRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class FirebaseClient {
    public void envoyer(NotificationRequestDTO request) {

        System.out.println("Envoi Firebase → " + request.getDestinataire());
        System.out.println(request.getTitre() + " : " + request.getMessage());
    }
}
