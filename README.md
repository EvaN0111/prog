# MusiVerse
## Η εφαρμογή MusiVerse χρησιμοποιόντας τεχνολογία AI παρέχει στον χρήστη εξατομικευμένη playlist τραγουδιών.
Ζητείται αρχικά από τον χρήστη να δημιουργήσει λογαριασμό στην εφαρμογή ή αν διαθέτει ήδη να συνδεθεί σε αυτόν. Στη συνέχεια του δίνονται 4 επιλογές:
1. Δημιουργία νέας playlist: Βάση του είδους μουσικής, διάθεσης και δεκαετίας που επιλέγει ο χρήστης.
2. Προβολή στατιστικών στοιχείων: Δημιουργία διαγράμματος πίτας με τα είδη μουσικής που έχει ακούσει ο συγκεκριμένος χρήστης.
3. Προβολή ιστορικού ειδών μουσικής: Αναγράφονται τα 10 τελευταία είδη μουσικής που έχει επιλέξει ο χρήστης καθώς και το πόσες φορές έχει επιλέξει το κάθε ένα από αυτά.
4. Έξοδος από την εφαρμογή.

# ΟΔΗΓΙΕΣ ΜΕΤΑΓΛΩΤΤΙΣΗΣ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ
1. Δημιουργία μεταβλητής περιβάλλοντος -> μεταβλητή συστήματος με όνομα 'API_KEY' και τιμή 'demo'
3. Ανοίξτε το cmd
4. Clone το repository με την εντολή: git clone https://github.com/your-username/prog.git
5. Εκτέλεση cd prog
6. Εκτέλεση εντολής mvn clean install
7.  

# ΟΔΗΓΙΕΣ ΧΡΗΣΗΣ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ
1. Αφού εμφανιστεί το πλαίσιο καλωσορίσματος, θα σας ζητηθεί να επιλέξετε να κάνετε Sign in (είσοδος) ή Sign up (εγγραφή). Εάν δεν έχετε λογαριασμό στην εφαρμογή, επιλεξτε το Sign Up, και εισαγετέ τα στοιχεία σας όπως αυτά θα σας ζητηθούν. Φροντίστε το Username σας να μην είναι κενό. Επιπλέον, σε περίπτωση που αυτό χρησιμοποιείται ήδη από κάποιον άλλο χρήστη, θα χρειαστεί να επιλέξετε ένα διαφορετικό. Εάν έχετε ήδη λογαριασμό, εισάγετε τα στοιχεία σας, το UserName και το Password που είχατε βάλει κατά την εγγραφή.
2. Όταν εισέλθετε στην εφαρμογή, θα σας δωθούν 4 επιλογές σχετικά με το ποιά λειτουργία της εφαρμογής θα θέλατε να χρησιμοποιήσετε. Οι 3 πρώτες επιλογες αφορούν τις διαθέσιμες ενέργειες εντός της εφαρμογής, και η τέταρτη σας επιτρέπει την ομαλή έξοδο από αυτή.
3. Μετά από την εκτέλεση οποιασδήποτε εκ των τριών ενεργειών, θα επιστρέφετε στο κεντρικό μενού, όπου θα σας δίνονται ξανά οι παραπάνω επιλογές. Η επιλογή της διαγραμματικής αναπαράστασης των στατιστικών στοιχείων θα είναι διαθέσιμη μόνο μία φορά κάθε φορα που συνδέεστε στην εφαρμογή.
4. Όταν θελήσετε να κλείσετε την εφαρμογή, ο καλύτερος τρόπος για να το κάνετε είναι πατώντας το κουμπί Sign out που βρήσκεται στο κεντρικό μενού, και όχι πατώντας τα "Χ" που βρίσκονται στο πάνω μέρος των πλαισίων.

# ΔΟΜΗ ΠΕΡΙΕΧΟΜΈΝΩΝ ΤΟΥ ΑΠΟΘΕΤΗΡΙΟΥ
Στο αποθετήριο μας υπάρχουν όλα τα απαραίτητα αρχεία για να τρέξετε την εφαρμογή. Μέσα στον φάκελο "src" υπάρχουν 2 άλλοι φάκελοι, εκ των οποίων ο ένας περιέχει όλες τις κλάσεις του προγράμματος και ο άλλος όλα τα Test που έχουμε δημιουργήσει. Στο αποθετήριο υπάρχει επίσης η βάση δεδομένων μας "UserInput.db" την οποία δημιουργήσαμε στο πρόγραμμα SQLite, καθώς και το αρχείο pom.xml.

# ΔΙΑΓΡΑΜΜΑ UML
Το διάγραμμα UML των κλάσεων μας παρουσιάζεται ως αρχείο PDF στο αποθετήριο μας με όνομα "UML3".

# ΧΡΗΣΙΜΟΠΟΙΟΥΜΕΝΟΙ ΑΛΓΟΡΙΘΜΟΙ ΚΑΙ ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ
Κατά την εγγραφή του χρήστη στην εφαρμοφή, όλα τα στοιχεία που εισάγει αποθηκεύονται στην βάση δεδομένων στους κατάλληλους πίνακες (Input) και παράλληλα δημιουργείται για εκείνον μια γραμμή στον πίνακα Genres όπου αρχικοποιούνται οι προσωπικοί του Counters των ειδών μουσικής και γίνονται μηδέν. Τα δεδομένα του πίνακα Input χρησιμοποιούνται για την σύνδεση του χρήστη ξανά στην εφαρμοφή αφού αποσυνδεθεί. Τα στοιχεία του πίνακα Genres ενημερώνονται κάθε φορά που ο χρήστης επιλέγει να του προταθεί μία νέα playlist και συμβάλλουν στην αποθήκευση των προτιμήσεων αυτού και στην παρουσίαση προσωποποιημέων δεδομένων και διαγραμμάτων. 
