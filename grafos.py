from posixpath import split
import re


#arq = input("Slecione o arquivo")
arq = ("teste.txt")
valor = input("Digite o vertice a ser pesquisado")



try:
    file = open(arq, "r")
    lista = file.readlines()
    #print(lista)
    contGrauEntrada = 0
    contGrauSaida = 0
    sucessores = []
    predecessores = []
    for i in lista:
        i = i.strip(' ').strip('\n')
        i = re.sub("\s+", " ", i)#substitui espaços em branco por um só
        i = i.split(' ')
        #print(i)
        
        #metodo para achar o conjunto de predecessores:
        #ele percorre o a lista de array até achar a posição desejada(entrada de dados)
        # verfica todos as arestas relacionadas aquele valor por meio da posicao 0 e 1 do array correspondentes ao m e n no modelo do professor
        #e adicona em uma nova lista de arrays (sucessores) todos esses valores
        #por fim par cada valor encontrado adicionamos +1 para sommar ao grau de entrada
        if i[0] == valor:
            sucessores.append(i[1])
            contGrauSaida += 1
            
        #mesma ideia do metodo de sucessores porem com os predecessores 
        elif i[1] == valor:
            predecessores.append(i[0])
            contGrauEntrada += 1
        
    
    print(f"\nGrau de saida ->{contGrauSaida}")
    print(f"\nGrau de entrada ->{contGrauEntrada}")
    print(f"\nSucessores ->{sucessores}")
    print(f"\nPredecessores ->{predecessores}\n")
    
    
    file.close()
    
except:
    ...