const tbody = document.getElementById('reports')

const urlPost = 'http://localhost:8080/reports'
const urlGet = 'http://localhost:8080/reports/'

const diaSemana = {     
    1: 'Domingo',
    2: 'Segunda',
    3: 'Terça',
    4: 'Quarta',
    5: 'Quinta',
    6: 'Sexta',
    7: 'Sabado'
}

const chaveTraduzida = {
        "date": 'Data',
        "day_week": 'Dia da Semana',
        "link_jadson_consumo": 'Consumo Jadson',
        "link_df_consumo": 'Consumo DF',
        "link_formosa_consumo": 'Consumo Formosa',
        "clients_online": 'Clientes Online',
        "clients_offline": 'Clientes Offline',
        "clients_blocked": 'Clientes bloqueados',
        "status_ar_is_ok": 'Ar-Condicionado',
        "switch_huawei_core_is_ok": 'Switch Huawei',
        "switch_datacom_link_is_ok": 'Datacon',
        "bgp_is_ok": 'BGP',
        "concentrador_is_ok": 'Concentrador',
        "backup_server_is_ok": 'Servidor Backup',
        "a10_is_ok": 'A10',
        "fonte1_is_ok": 'Fonte 1',
        "fonte2_is_ok": 'Fonte 2',
        "fonte3_is_ok": 'Fonte 3',
        "quadro1_is_ok": 'Quadro 1',
        "quadro2_is_ok": 'Quadro 2',
        "quadro3_is_ok": 'Quadro 3',
        "inversora_is_ok": 'Inversora',
        "oltc300_is_ok": 'OLT C300',
        "oltc650_is_ok": 'OLT C650',
        "whatsapp_status": "Status Whatsapp",
        "system_manager_is_ok": 'Hubsoft',
        "site_is_ok": 'Site Unafiber',
        "voip_is_ok": 'Voip',
        "devices_ont": 'ONTs gerenciados',
        "devices_local": 'Ztes gerenciados',
}


function searchReport(event) {
    event.preventDefault()

    const confirmar = confirm("Tem certeza?")
    

    if (confirmar) {
        const date = document.getElementById('date').value


        getApi(date)

        const table = document.getElementById('reports-result')
        table.style.display = 'block'

        table.scrollIntoView({behavior: 'smooth'})

    }
}  


async function getApi(date) {
    const url = urlGet + `${date}`

    const resposta = await fetch(url)
    const dados = await resposta.json()

    showDados(dados)
}

const showDados = (resultado) => {

    
    let tag = ``

    tag = tag + `
        <tr class="tr-reports-api">
            <td class="td-reports-api"><strong>Data</strong></td>
            <td class="td-reports-api">${inverterString(resultado['date'])}</td>
        </tr>
    `

    for (let chave in resultado) {

        if (chave == 'date') {
            continue
        }

        if (chave == 'day_week') {
            tag = tag + createLine(chave, diaSemana[resultado[chave]])
            continue
        }


        if (chave ==  "link_jadson_consumo" 
            || chave == "link_df_consumo" 
            || chave == "link_formosa_consumo") {
                tag = tag + createLine(chave, resultado[chave], true)
                continue
        }

        tag = tag + createLine(chave, resultado[chave])
    } 

    tbody.innerHTML = tag
}

const createLine = (chave, valor, consumo) => {

    switch (valor) {
        case true:
            valor = "OK"
            break;
        case false:
            valor = "Com problemas"
            break
        default:
            break
    }

    if (consumo){
        return `
        <tr class="tr-reports-api">
            <td class="td-reports-api"><strong>${chaveTraduzida[chave]}</strong></td>
            <td class="td-reports-api">${valor} GB</td>
        </tr>
        `
    }
    
    return `
    <tr class="tr-reports-api">
        <td class="td-reports-api"><strong>${chaveTraduzida[chave]}</strong></td>
        <td class="td-reports-api">${valor}</td>
    </tr>
    `
}


function inverterString(str) {  
    // Dividir a string em um array de caracteres
    var caracteres = str.split('-');
    
    // Inverter a ordem dos elementos do array
    var caracteresInvertidos = caracteres.reverse();
    
    // Juntar os caracteres invertidos de volta em uma string
    var stringInvertida = caracteresInvertidos.join('-');
    
    return stringInvertida;
}

function editReports(object) {

}

async function postReports(url, json) {


    const request = {    
        method: "POST",     
        headers: {
            'Content-Type': "application/json",

        },
        body: JSON.stringify(json)
        
    }


    const response = await fetch(url, request)
    const data = await response.json()

    if (data.message == 'Report Already Exists') {
        alert('Relatorio desse dia já existe, caso queria alterar vai em editar relatorios')
    }
    

}


function createLineReports(date) {

    return `
        <tr>
            <td>${inverterString(date)}</td>
            <td class="td-reports-list">
                <i class="fa-solid fa-pen fa-lg icon-reports-editor" onclick="editReport('${date}')"></i>
                <i class="fa-solid fa-trash fa-lg icon-reports-delete" onclick="deleteReport('${date}')"></i>
            </td>
        </tr>
    `

}

function newReports(event) {
    event.preventDefault()

    const form = new FormData(event.target)
    let formJson = {}

    form.forEach((key, value) => {  

        if (value == 'day_week'
        || value == 'clients_online' 
        || value == 'clients_offline' 
        || value == 'clients_blocked' 
        || value == 'devices_ont' 
        || value == 'devices_local') {
            formJson[value] = parseInt(key)
        } else {
            if (key == 'true') {
                formJson[value] = true
            } else if (key == 'false') {
                formJson[value] = false
            } else if (value == 'link_df_consumo' || value =='link_formosa_consumo' || value == 'link_jadson_consumo' ){
                formJson[value] = parseFloat(key)
            } else {
                formJson[value] = key
            }
        }
    });

    console.log(formJson)


    postReports(urlPost, formJson)
}

async function pullReport() {

    const response = await fetch(urlPost)
    const data = await response.json()  

    document.getElementById('last-report').innerHTML = createLineReports(data['reportDateDTOList'][data['reportDateDTOList'].length-1])


}

pullReport()


