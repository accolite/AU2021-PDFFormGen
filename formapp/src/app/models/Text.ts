export class Textfield {
    fgid: number;

    name: string;
    is_required: number;
    max_length: number;
    min_length: number;
    constructor(
        fgid: number,name: string,
        is_required: number,
        max_length: number,
        min_length: number){
        this.fgid = fgid;
        this.name = name;
        this.is_required = is_required;
        this.max_length = max_length;
        this.min_length = min_length;
    }
}