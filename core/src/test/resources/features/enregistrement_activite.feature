# language: fr
Fonctionnalité: enregistrement d'une activité

    Afin d'avoir un traçabilité de mes activités,
    j'aimerai pouvoir les enregistré.


    Scénario: enregistrement basique d'une activité
        Enregistrement d'une activité sans detail.

        Etant donné que j'ai "lue le livre cuisine facile" le "12-01-2021" de "06:30" à "10:30"
        Quand je l'enregistre avec comme cle "lecture"
        Alors l'activité suivant devrait exister dans mes activités
            | date       | heure commencement | heure fin | nom activité                | mot cle |
            | 12-01-2021 | 06:30              | 10:30     | lue le livre cuisine facile | lecture |


    Scénario: enregistremnt detaillé d'une activité 

        Enregistrement d'une activité avec des details.

        Etant donné que j'ai "lue le livre cuisine facile" le "12-01-2021" de "06:30" à "10:30"
        Quand je le dataille avec la phrase : "J'aurais pu le finir en 30 minutes mais j'ai été distrait avec les bruits des voisins."
        Et l'enregistre avec comme cles "lecture, non productive"
        Alors l'activité suivant devrait exister dans mes activités
            | date       | heure commencement | heure fin | nom activité                | mot cle                 |
            | 12-01-2021 | 06:30              | 10:30     | lue le livre cuisine facile | lecture, non productive |
        Et qui devrait avoir comme detail : "J'aurais pu le finir en 30 minutes mais j'ai été distrait avec les bruits des voisins."


    Scénario: l'activité s'etant entre deux date

        Etant donné que j'ai "rediger mon livre de fin d'etude" le "12-01-2021" à "21:30" jusqu'au "13-01-2021" à "02:30"
        Quand je l'enregistre avec les mots cles "redaction livre, tres productive"
        Alors l'activité qui suit devrait exister dans mes activités
            | date debut | date fin   | heure debut | heure fin | nom activité                     | mot cle                          |
            | 12-01-2021 | 13-01-2021 | 21:30       | 02:30     | rediger mon livre de fin d'etude | redaction livre, tres productive |


