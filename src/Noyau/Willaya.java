package Noyau;
public enum Willaya {

    Adrar(20000),Chlef(20000),Laghouat(20000),OumelBouaghi(20000),Batna(20000),Bejaia(20000),Biskra(20000),Bechar(20000),Blida(20000),Bouira(20000),Tamanrasset(2000),Tebessa(2000),Tlemcen(2000),Tiaret(2000),TiziOuzou(2000),Alger(70000),Djelfa(2000),Jijel(2000),Setif(2000),Saida(2000),Skikda(2000),SidiBelAbbes(20000),Annaba(2000),Guelma(2000),Constantine(2000),Medea(20000),Mostaganem(20000),Msila(2000),Mascara(2000),Ouargla(2000),Oran(2000),Elbayadh(2000),Illizi(2000),BordjBouArreridj(2000),Boumerdes(2000),ElTarf(2000),Tindouf(2000),Tissemsilt(2000),ElOued(2000),Khenchela(2000),SoukAhras(2000),Tipaza(2000),Mila(2000),AinDefla(2000),Naama(2000),AinTemouchent(2000),Ghardaia(2000),Relizane(2000) ;
    private long prixMC ;

    Willaya ( long priceMC )
    {
        this.prixMC = priceMC ;
    }

    public long getpriceMC ()
    {
        return prixMC ;
    } 
}