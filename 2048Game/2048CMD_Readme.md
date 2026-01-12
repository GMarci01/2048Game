2048 CMD Readme: (English below)



Az indítás menete:

1\. A weboldalukról töltsd le a játékot tartalmazó tömörített mappát (ZIP), majd csomagold ki a tartalmát.

2\. A ***https://www.java.com/en/download/*** linkről töltsd le a Java környezet letöltőjét, majd és telepítsd fel.

3\. Amikor a Java környezet feltelepült, nyisd meg a Windows CMD-t (admin jogok nem szükségesek), majd a **cd** parancs segítségével navigálj a kicsomagolt mappához (például: ***cd C:\\User\\UsersName\\Desktop\\2048***)

4\. Írd be a következő parancsot: ***java -cp ".;lib\\jline-3.26.3.jar" feleviprojekt*** majd nyomd meg az entert.



FONTOS! Amennyiben játék nem nyílik meg, illetve hibakód jelenik meg, töröld a ***feleviprojekt.class*** fájlt a kicsomagolt mappából, majd hozz létre egy újat a ***javac -cp ".;lib\\jline-3.26.3.jar" feleviprojekt.java*** parancs segítségével. 



Irányítások:

W - A számok tolása felfelé.

S - A számok tolása lefelé.

A - A számok eltolása balra

D - A számok eltolása jobbra.




Jó játékot kívánunk!



// English:



Startup procedure:

1\. From our website, download the compressed folder (ZIP), and extract its contents.

2\. From this link: ***https://www.java.com/en/download/*** download the Java Runtime installer, and install it.

3\. After Java Runtime has been installed, open the Windows CMD (Admin rights are not required), and with the cd command, navitage to the folder you have extracted from the zip, for example: ***cd C:\\User\\UsersName\\Desktop\\2048***. 

4\. When you have successfully navigated to the right folder, insert the following code: ***java -cp ".;lib\\jline-3.26.3.jar"*** and hit enter.



IMPORTANT! If the game does not start, or it gives an error, please delete the ***feleviprojekt.class*** file from the main folder, and create a new one using this command: ***javac -cp ".;lib\\jline-3.26.3.jar" feleviprojekt.java*** . This command only works and has any effect if you are navigated to the correct folder!



Controls:

W - Move the numbers up.

S - Move the numbers down.

A - Move the numbers to the left.

D - Move the numbers to the right.






We wish you a happy gameplay!




