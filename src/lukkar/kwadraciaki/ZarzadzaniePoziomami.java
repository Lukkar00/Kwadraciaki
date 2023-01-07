package lukkar.kwadraciaki;

class ZarzadzaniePoziomami {
    int poziom;
    int poziomDocelowy[][];
    int poziomRysowany[][];

    ZarzadzaniePoziomami() {
        this.wybierzPoziom(10);
    }

    void wybierzPoziom(int poziom) {
        Poziomy poziomy = new Poziomy();
        this.poziom = poziom;
        this.poziomDocelowy = poziomy.wybierzPoziom(poziom);
        this.poziomRysowany = this.poziomDocelowy.clone();
        int temp[];
        for (int i = 0; i<poziom+2; i++) {
            temp = this.poziomRysowany[i].clone();
            for (int j = 0; j<poziom+2; j++) {
                temp[j] = 0;
            }
            this.poziomRysowany[i] = temp;
        }
    }

}
