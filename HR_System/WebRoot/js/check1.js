$ = function(el) {
        return document.querySelector(el);
    }
    $$ = function(el) {
        return document.querySelectorAll(el);
    }
    var checkResult = {
        right: false,
        tip: ''
    }
    var inputEles = [$('#add-num'), $('#add-name'), $('#add-phone'), $('#add-time')];
    var originTip = ['����Ϊ3-10���ַ�', '����2��16λ������', '������11λ�绰����','�������������'];
    function checkValue(ele) {
        var str = ele.value.trim();
        if (str.length === 0) {
            checkResult.right = false;
            checkResult.tip = '���벻��Ϊ��';
            return;
        }
        // ����
        if (ele === inputEles[0]) {
            var len = str.replace(new RegExp('[^\x00-\xff]', 'g'), 'aa').length;
            if (len >= 3 && len <= 10) {
                checkResult.right = true;
                checkResult.tip = '��ſ���';
            } else {
                checkResult.right = false;
                checkResult.tip = '���������ַ���';
            }
        }
        if (ele === inputEles[1]) {
            if (str.match(/^[\u4E00-\u9FA5]{2,16}$/)) {
                checkResult.right = true;
                checkResult.tip = '��ʽ��ȷ';
            } else {
                checkResult.right = false;
                checkResult.tip = '������2��16λ������';
            }
        }
        
        if (ele === inputEles[2]) {
            if (str.match(/^1\d{10}$/)) {
                checkResult.right = true;
                checkResult.tip = '�������';
            } else {
                checkResult.right = false;
                checkResult.tip = '�����ʽ����';
            }
        }
        if (ele === inputEles[3]) {
            if (str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/)) {
                checkResult.right = true;
                checkResult.tip = '��ʽ��ȷ';
            } else {
                checkResult.right = false;
                checkResult.tip = '�������������';
            }
        }
    }
    for (var i = 0; i < inputEles.length; i++) {
        inputEles[i].addEventListener('blur', function(e) {
            checkValue(e.target);
            var span = e.target.parentElement.getElementsByTagName('span')[0];
            span.innerHTML = checkResult.tip;
            if (checkResult.right) {
                e.target.style.border = '1px solid #53c7a0';
                span.style.color = '#53c7a0';
                span.style.fontSize=8+'px';
            } else {
                e.target.style.border = '1px solid #e8614b';
                span.style.color = '#e8614b';
            }
        })
        inputEles[i].addEventListener('focus', function(e) {
            var index = inputEles.indexOf(e.target);
            var span = e.target.parentElement.getElementsByTagName('span')[0];
            span.innerHTML = originTip[index];
            span.style.visibility = 'visible';
            span.style.color = 'gray';
            span.style.fontSize=8+'px';
        })
    }
    $('#check').addEventListener('click', function(e) {
        var right = true;
        for (var i = 0; i < inputEles.length; i++) {
            var input = inputEles[i];
            checkValue(input);
            var span = input.parentElement.getElementsByTagName('span')[0];
            span.style.visibility = 'visible';
            span.innerHTML = checkResult.tip;
            if (checkResult.right) {
                input.style.border = '1px solid #53c7a0';
                span.style.color = '#53c7a0';
                span.style.fontSize=8+'px';
            } else {
                input.style.border = '1px solid red';
                span.style.color = 'red';
                span.style.fontSize=8+'px';
                right = false;
            }
        }
        if (right) {
            alert('�����ɹ�');
        } else {
            alert('�ύʧ�ܣ���������');
        }
    })

