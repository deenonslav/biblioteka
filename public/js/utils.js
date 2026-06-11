async function httpGet(url) {
    const response = await fetch(url);
    return await response.json();
}

async function httpPost(url, data) {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    return await response.json();
}

async function httpPut(url, data) {
    const response = await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    return await response.json();
}

async function httpDelete(url) {
    const response = await fetch(url, {
        method: 'DELETE'
    });
    return response.status;
}
