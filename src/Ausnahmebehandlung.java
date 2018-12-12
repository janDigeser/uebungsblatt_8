/*
*   Ausnahmebehandlung spielt eine große Rolle in der Entwicklung in großen
*   Projekten.
*
*   In dieser Datei möchte ich euch deshalb die Verwendung näher bringen.
*
*   Um Fehler abzufangen sollten wir zuerst wissen woher die Fehler kommen.
*   Die schwerwiegenden Errors treten bei Compilierung oder zur Runtime auf,
*   wenn ein nicht behandelbarer Zustand zustande kommt.
*   Die Exceptions jedoch können gezielt "geworfen" werden, (mit dem Keyword
*   "throw")
*
*   Man kann auch eigene Exceptions schreiben. Das macht in Projekten Sinn um
*   feststellen zu können was genau passiert ist.
*
*
 */

class Ausnahmen{

    // Diese Funktion produziert eine ArithmeticException weil wir durch Null teilen
    // weil ich im Vorraus weiß welche Fehler geworfen werden können, kann man
    // (bzw. muss man bei schwerwiegenden Fehlern) dies kennzeichnen mit dem Ausdruck
    // "<Name der Funktion>(...) throws <Hier eine Exception>{..."
    // Damit weiß der Compiler und die IDE dass mit dem Aufruf ein Fehler auftreten kann
    void testArithmeticException() throws ArithmeticException{
        int a = 1;
        int b = 0;
        int c = a / b;
    }

    /*
    * In dieser Funktion möchten wir den Fehler abfangen und dafür sorgen dass das Programm
    * weiterläuft auch wenn ein bestimmter Fehler auftritt
     */
    void abfangen(){
        try{
            testArithmeticException(); // hier gibt es eine ArithmeticException
        }catch (ArithmeticException e){
            System.out.println("Fehler abgefangen");
            // Dinge die getan werden müssen wenn dieser Fehler auftritt
        }finally{
            System.out.println("Hier werden letztendlich alle nonch offenen Aufgaben beendet");
            // Code wird ausgeführt egal ob Fehler auftrat oder nicht
        }

        // Natürlich kann auch nach dem try-catch noch code stehen
    }
}

/*
* Um eigene Ausnahmen zu schreiben sollte man eigenltich zuerst Kenntnisse von
* Vererbung haben aber hier ein ganz Kurzes beispiel:
*
 */

// natürlich kann auch von einer Spezielleren Exception vererbt werden
class MyFirstException extends Exception{
    String value;
    MyFirstException(String value){
        this.value = value;
    }
}

// kann jetzt mit "throw new MyFirstException(...)" geworfen und mit
// "catch(MyFirstException e) " gefangen werden.
