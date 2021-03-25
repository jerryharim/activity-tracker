# language: fr
Fonctionnalité: enregistrement d'une activité

    Afin d'avoir un traçabilité de mes activités,
    j'aimerai pouvoir les enregistré.


    Contexte: 

        Etant donné que j'ai "lue le livre cuisine facile" le "12-01-2021" de "06:30" à "10:30"

    Scénario: enregistrement basique d'une activité

        Enregistrement d'une activité sans detail.

        Quand je l'enregistre avec comme cle "lecture"
        Alors l'activité suivant devrait exister dans mes activités
            | date      | heure commencement | heure fin | nom activité                | mot cle |
            | 12-01-201 | 06:30              | 10:30     | lue le livre cuisine facile | lecture |

    Scénario: enregistremnt detaillé d'une activité 

        Enregistrement d'une activité avec des details.

        Quand je le dataille avec la phrase : "J'aurais pu le finir en 30 minutes mais j'ai été distrait avec les bruits des voisins."
        Et l'enregistre avec comme cles "lecture, non productive"
        Alors l'activité suivant devrait exister dans mes activités
            | date      | heure commencement | heure fin | nom activité                | mot cle                 |
            | 12-01-201 | 06:30              | 10:30     | lue le livre cuisine facile | lecture, non productive |
        Et qui devrait avoir comme detail : "J'aurais pu le finir en 30 minutes mais j'ai été distrait avec les bruits des voisins."
